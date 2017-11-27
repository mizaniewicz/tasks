package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {
    @Autowired
    DbService dbService;

    @Test
    public void shouldGetAllTasks() throws Exception {
        //Given
        Task task = new Task(1, "task", "test task");
        dbService.saveTask(task);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        Assert.assertEquals(1, taskList.size());
        Assert.assertEquals("task", taskList.get(0).getTitle());
        //Cleanup
        dbService.deleteTask(taskList.get(0).getId());
    }
}