package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.ArticleDTO;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.Article;
import com.poverty.entity.po.BrowsingHistory;
import com.poverty.entity.po.Count;
import com.poverty.entity.vo.ArticleVO;
import com.poverty.entity.vo.ArticlesVO;
import com.poverty.entity.vo.Page;
import com.poverty.mapper.ArticleMapper;
import com.poverty.mapper.BrowsingHistoryMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.mapper.UserMapper;
import com.poverty.service.ArticleService;
import com.poverty.util.PageUtil;
import com.poverty.util.PathUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 8:47
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CountMapper countMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PathUtil pathUtil;

    @Override
    public Result getArticleList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = articleMapper.selectIsExaminedArticleList(start, end);
        int total = countMapper.countIsExaminedArticle();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

    /**
     * 获取文章
     *
     * @param id 文章id
     * @return Result
     */
    @Override
    public Result getArticleById(String id, String userId) {
        ArticleVO article = articleMapper.getArticleById(id);
        countMapper.updateRecommendById(id);

        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setUserId(userId);
        browsingHistory.setArticleId(id);

        browsingHistoryMapper.insertOne(browsingHistory);

        return Result.result200(article);
    }

    /**
     * 保存文章
     *
     * @param articleDTO JSON{"title":"标题","articleUrl":"文章html的url","text":"文章部分内容","account":"账号"}
     * @return Result
     */
    @Override
    public Result insertArticle(ArticleDTO articleDTO) throws Exception {
        String id = UUID.randomUUID().toString().replace("-", "");

        Article article = new Article();
        article.setId(id);
        article.setTitle(articleDTO.getTitle());
        article.setText(articleDTO.getText());
        String url = articleDTO.getArticleUrl();
        article.setArticleUrl(url);

        String userId = userMapper.selectIdByAccount(articleDTO.getAccount());
        article.setAuthorId(userId);
        String prefix = url.substring(url.indexOf("/") + 1, url.indexOf(".html"));
        String pictureUrl = prefix + "/" + prefix + "_img1.jpeg";
        if (new File(pathUtil.getImagePath() + pictureUrl).exists()) {
            article.setPictureUrl("/static/image/" + pictureUrl);
        }

        Count count = new Count();
        count.setId(id);

        if (articleMapper.insertOne(article) && countMapper.insertCount(count)) {
            return Result.result200("上传成功！");
        } else {
            throw new Exception();
        }

    }

    /**
     * 通过文章id删除文章
     *
     * @param id JSON{"id":"文章id"}
     * @return Result
     */
    @Override
    public Result deleteArticleById(PostId id) throws Exception {
        List<String> list = new ArrayList<>();
        list.add(id.getId());
        if (articleMapper.deleteArticleByIds(list) && countMapper.deleteByIds(list)) {
            return Result.result200("删除成功");
        } else {
            throw new Exception();
        }
    }
}
