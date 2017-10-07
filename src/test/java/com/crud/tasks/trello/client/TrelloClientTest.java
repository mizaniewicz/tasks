package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.trellobadges.AttachmentsByType;
import com.crud.tasks.domain.trellobadges.TrelloAttachment;
import com.crud.tasks.domain.trellobadges.TrelloBadges;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {
    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Before
    public void init() {
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
    }

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        //Given
        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "test_board", new ArrayList<>());

        //When

        List<TrelloBoardDto> fetchedTrelloBoard = trelloClient.getTrelloBoards();
        when(restTemplate.getForObject("http://test.com/members/TWOJ_USERNAME_TRELLO/boards?key=test&token=test&fields=name,id&lists=all", TrelloBoardDto[].class))
                .thenReturn(trelloBoards);

        System.out.println(fetchedTrelloBoard);
        //Then
//        assertEquals(1, fetchedTrelloBoard.size());
//        assertEquals("test_id", fetchedTrelloBoard.get(0).getId());
//        assertEquals("test_board", fetchedTrelloBoard.get(0).getName());
//        assertEquals(new ArrayList<>(), fetchedTrelloBoard.get(0).getLists());
    }

//    @Test
//    public void shouldCreateCard() throws URISyntaxException {
//        //Given
//        TrelloCardDto trelloCardDto = new TrelloCardDto(
//                "Test task",
//                "Test description",
//                "top",
//                "test_id"
//        );
//
//        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20Description&pos=top&idList=test_id");
//
//        CreatedTrelloCard createdTrelloCard = new CreatedTrelloCard(
//                "1",
//                "Test task",
//                "http://test.com",
//                new TrelloBadges(0, new AttachmentsByType(new TrelloAttachment(0, 0)))
//        );
//
//        when(restTemplate.postForObject(uri, null, CreatedTrelloCard.class)).thenReturn(createdTrelloCard);
//        //When
//        CreatedTrelloCard newCard = trelloClient.crateNewCard(trelloCardDto);
//        //Then
//        assertEquals(1, newCard.getId());
//    }
}