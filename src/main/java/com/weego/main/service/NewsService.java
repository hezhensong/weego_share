package com.weego.main.service;


import com.weego.main.dto.NewsDto;

public interface NewsService {

    NewsDto getNewsById(String newsId);

}
