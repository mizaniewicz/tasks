package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TaskMapperTest {
    @Test
    public void shouldMapToTask() {
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto= new TaskDto(1l, "taskDto", "test taskDto");

        Task task = taskMapper.mapToTask(taskDto);

        assertEquals(1, task.getId());
        assertEquals("taskDto", task.getTitle());
        assertEquals("test taskDto", task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1l, "task", "test task");

        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        assertEquals(1, taskDto.getId());
        assertEquals("task", taskDto.getTitle());
        assertEquals("test task", taskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        TaskMapper taskMapper = new TaskMapper();
        Task task1 = new Task(1l, "task1", "test task1");
        Task task2 = new Task(2l, "task2", "test task2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        assertEquals(2, taskDtoList.size());
        assertEquals("task1", taskDtoList.get(0).getTitle());
    }
}