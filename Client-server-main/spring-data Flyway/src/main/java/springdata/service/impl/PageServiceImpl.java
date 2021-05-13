package kz.reself.springdata.service.impl;

import kz.reself.springdata.entity.Page;
import kz.reself.springdata.repository.PageRepository;
import kz.reself.springdata.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public List<Page> getAll() {
        return pageRepository.findAll();
    }
}
