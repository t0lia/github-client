package com.t0lia.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GhRepo {
    private String id;
    private String node_id;
    private String name;
    @JsonProperty("private")
    private String pr1vate;
    private String full_name;
    private GhUser owner;
    private String html_url;
    private String description;
    private String fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private String homepage;
    private String size;
    private String stargazers_count;
    private String watchers_count;
    private String language;
    private String has_issues;
    private String has_projects;
    private String has_downloads;
    private String has_wiki;
    private String has_pages;
    private String forks_count;
    private String mirror_url;
    private String archived;
    private String disabled;
    private String open_issues_count;
    private GhLicense license;
    private String forks;
    private String open_issues;
    private String watchers;
    private String default_branch;
}
