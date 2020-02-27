package com.t0lia;

import com.mashape.unirest.http.Unirest;
import com.t0lia.domain.GhRepo;
import com.t0lia.domain.GhUser;
import com.t0lia.domain.Summary;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static com.t0lia.ExceptionWrapper.wrap;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Github rest api app.
 */
public class App {

    private static final String USER_URL = "https://api.github.com/users/%s";
    private static final String REPOS_URL = "https://api.github.com/users/%s/repos";
    private static final String FOLLOWERS_URL = "https://api.github.com/users/%s/followers";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please put github username as argument");
            return;
        }
        String username = args[0];

        SetUp.unirest();

        CompletableFuture<GhUser> user = supplyAsync(() -> getUser(username));
        CompletableFuture<GhUser[]> followers = supplyAsync(() -> getFollowers(username));
        CompletableFuture<GhRepo[]> repos = supplyAsync(() -> getUserRepos(username));

        supplyAsync(Summary::new)
                .thenCompose(summary -> followers.thenApplyAsync(summary::setFollowers))
                .thenCompose(summary -> repos.thenApplyAsync(summary::setRepos))
                .thenCompose(summary -> user.thenApplyAsync(summary::setUser))
                .thenAccept(App::printSummary)
                .join();

    }

    private static void printSummary(Summary summary) {
        GhUser user = summary.getUser();
        System.out.println(" ================================= Github info ===========================================");
        System.out.printf("| %-20s | %-60s     | \n", user.getLogin(), user.getHtml_url());
        System.out.println(" ================================= Followers =============================================");
        Arrays.stream(summary.getFollowers())
                .forEach(f -> System.out.printf("| %-20s | %-60s     | \n", f.getLogin(), f.getHtml_url()));
        System.out.println(" ================================= Repositories ==========================================");
        Arrays.stream(summary.getRepos()).forEach(r -> {
            System.out.printf("| %-20s | %-10s | %-50s  | \n", r.getName(), r.getLanguage(), r.getHtml_url());
        });
        System.out.println(" =========================================================================================");
    }

    private static GhUser getUser(String user) {
        return wrap(() ->
                Unirest.get(String.format(USER_URL, user))
                        .header("accept", "application/json")
                        .asObject(GhUser.class).getBody()
        );
    }

    private static GhUser[] getFollowers(String user) {
        return wrap(() ->
                Unirest.get(String.format(FOLLOWERS_URL, user))
                        .header("accept", "application/json")
                        .asObject(GhUser[].class).getBody()
        );
    }

    private static GhRepo[] getUserRepos(String user) {
        return wrap(() ->
                Unirest.get(String.format(REPOS_URL, user))
                        .header("accept", "application/json")
                        .asObject(GhRepo[].class).getBody()
        );
    }
}
