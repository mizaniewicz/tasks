package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloMapperTest {
    @Test
    public void shouldMapToBoards() {
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "test list", false));
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "test board", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        assertEquals(1, trelloBoards.size());
        assertEquals("1", trelloBoards.get(0).getId());
    }

    @Test
    public void shouldMapToBoardsDto() {
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test list", false));
        TrelloBoard trelloBoard = new TrelloBoard("1", "test board", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        assertEquals(1, trelloBoardDtos.size());
        assertEquals("1", trelloBoardDtos.get(0).getId());
    }

    @Test
    public void shouldMapToList() {
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "test list", false));

        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        assertEquals(1, trelloLists.size());
        assertEquals("1", trelloLists.get(0).getId());
    }

    @Test
    public void shouldMapToListDto() {
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test list", false));

        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        assertEquals(1, trelloListDtos.size());
        assertEquals("1", trelloListDtos.get(0).getId());
    }

    @Test
    public void shouldMapToCardDto() {
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("test", "test description", "top", "1");

        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        assertEquals("test", trelloCardDto.getName());
        assertEquals("test description", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void shouldMapToCard() {
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test description", "top", "1");

        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertEquals("test", trelloCard.getName());
        assertEquals("test description", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }
}