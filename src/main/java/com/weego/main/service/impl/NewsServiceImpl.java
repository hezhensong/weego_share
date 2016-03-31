package com.weego.main.service.impl;


import com.weego.main.dao.NewsDao;
import com.weego.main.dto.NewsContentDto;
import com.weego.main.dto.NewsDto;
import com.weego.main.model.News;
import com.weego.main.model.NewsContent;
import com.weego.main.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDao newsDao;

    @Override
    public NewsDto getNewsById(String newsId) {
        News news = newsDao.getNewsById(newsId);

        if (news == null) {
            return null;
        } else {
            NewsDto newsDto = new NewsDto();
            newsDto.setLead(news.getLead());
            newsDto.setLeadText(news.getLeadText());
            newsDto.setImage(news.getImage());

            List<NewsContentDto> newsContentDtoList = new ArrayList<>();
            newsDto.setContents(newsContentDtoList);

            if (news.getNewsContentList() != null) {
                for (NewsContent content : news.getNewsContentList()) {
                    NewsContentDto newsContentDto = new NewsContentDto();

                    newsContentDto.setTitle(content.getTitle() == null ? "" : content.getTitle());
                    newsContentDto.setDate(content.getDate() == null ? "" : content.getDate());
                    newsContentDto.setSource(content.getSource() == null ? "" : content.getSource());
                    newsContentDto.setImage(content.getImage() == null ? "" : content.getImage());
                    newsContentDto.setImageDesc(content.getImageDesc() == null ? "" : content.getImageDesc());
                    newsContentDto.setText(content.getText() == null ? "" : content.getText());
                    newsContentDto.setUrl(content.getUrl() == null ? "" : content.getUrl());

                    newsContentDtoList.add(newsContentDto);
                }
            }

            return newsDto;
        }
    }
}
