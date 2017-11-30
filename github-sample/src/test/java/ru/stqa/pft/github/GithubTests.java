package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {


    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("88222538fa9e832d747455f0138b743f97b2118c ");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("vori1987", "java_pft2")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}