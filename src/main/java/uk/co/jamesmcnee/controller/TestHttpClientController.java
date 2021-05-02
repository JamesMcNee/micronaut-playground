package uk.co.jamesmcnee.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.HttpMessage;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.HttpClient;
import io.reactivex.Single;
import org.reactivestreams.Publisher;
import uk.co.jamesmcnee.controller.model.HelloResponse;

import javax.inject.Inject;
import java.util.Optional;

@Controller("/api/httpclient")
public class TestHttpClientController {

    private HttpClient httpClient;

    @Inject
    public TestHttpClientController(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Get(produces = "application/json")
    public Single<TodoResponse> test() {
        Single<HttpResponse<TodoResponse>> exchange = Single.fromPublisher(httpClient.exchange("https://jsonplaceholder.typicode.com/todos/2", TodoResponse.class));

        return exchange.map(HttpMessage::getBody).map(Optional::get);
    }

    private static class TodoResponse {

        private final int userId;
        private final int id;
        private final String title;
        private final boolean completed;

        @JsonCreator
        public TodoResponse(@JsonProperty("userId") int userId,
                            @JsonProperty("id") int id,
                            @JsonProperty("title") String title,
                            @JsonProperty("completed") boolean completed) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        public int getUserId() {
            return userId;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCompleted() {
            return completed;
        }
    }
}
