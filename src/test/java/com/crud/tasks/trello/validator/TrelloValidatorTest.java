package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTest {
    @Test
    public void shouldValidateTrelloCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test card", "test description", "top", "test list");
        TrelloValidator validator = new TrelloValidator();
        //When
        validator.validateCard(trelloCard);
        //Then
        Assert.assertTrue("Someone is testing my application", true);
    }

    @Test
    public void shouldValidateTrelloBoard() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList list = new TrelloList("1", "test list", false);
        trelloLists.add(list);
        TrelloBoard board1 = new TrelloBoard("1", "test", trelloLists);
        TrelloBoard board2 = new TrelloBoard("2", "board 2", trelloLists);
        trelloBoards.add(board1);
        trelloBoards.add(board2);
        TrelloValidator validator = new TrelloValidator();
        //When
        List<TrelloBoard> testList = validator.validateTrelloBoard(trelloBoards);
        //Then
        Assert.assertEquals(1, testList.size());
        Assert.assertEquals("2", testList.get(0).getId());
    }
}