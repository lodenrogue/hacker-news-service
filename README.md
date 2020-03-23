# hacker-news-service
Hacker News Java Service

## Services Available
- TopStoryService
- ShowStoryService
- NewStoryService

## How to use
```
List<Story> stories = new TopStoryService().getAllStories();
System.out.println(new GsonBuilder()
      .setPrettyPrinting()
      .create()
      .toJson(stories));
```
