package com.finance.testproject.thread;

import com.finance.testproject.model.Pipeline;
import com.finance.testproject.model.Status;
import com.finance.testproject.model.Task;

import java.sql.Timestamp;

public class CompletedAction extends AbstractAction {

    public CompletedAction(Task task, Pipeline pipeline) {
        super(task, pipeline);
    }

    @Override
    public void run() {
        waitAnotherTasks();
        task.setStartTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(task.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.setStatus(Status.COMPLETED);
        task.setEndTime(new Timestamp(System.currentTimeMillis()));
    }
}
