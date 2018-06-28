package com.finance.testproject.service;

import com.finance.testproject.dao.PipelineDAO;
import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Task;
import com.finance.testproject.model.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PipelineServiceImpl implements PipelineService {

    @Autowired
    private PipelineDAO pipelineDAO;

    @Override
    public Pipeline createPipeline(String name, String description, List<Task> tasks, Set<Transition> transactions) {
        Pipeline pipeline = new Pipeline(name, description, tasks, transactions);
        pipelineDAO.addPipeline(pipeline);
        return pipeline;
    }

    @Override
    public Pipeline findPipeline(int id) {
        return pipelineDAO.getPipelineById(id);
    }

    @Override
    public void deletePipeline(int id) {
        pipelineDAO.deletePipeline(id);
    }

    @Override
    public void updatePipeline(Pipeline pipeline) {
        pipelineDAO.updatePipeline(pipeline);
    }
}