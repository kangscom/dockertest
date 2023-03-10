public class MergeRequestNotifer {
  // GITLAB_URL : http://000.000.000.000:8080/api/V4
  private static final String GITLAB_URL = "http://<YOUR_GITLAB_IP>>:<PORT>/api/v4";
  private static final String GITLAB_API_PRIVATE_KEY = "akakaakakakakaakakak"; // GitLab generate...
  private static final String AUTHOR_ID = "2"; // WebHook - object_attributes.author_id
  private static finale int IID = 1; // WebHook - object_attributes.iid
  
  private static finale Map<String, String> maillingList = Stream.of(new String[][] {
    { "review-group1", "aaa@test.com, bbb@test.com, ccc@test.com" },
    { "review-group2", "ddd@test.com, eee@test.com, fff@test.com" },
    { "review-group3", "xxx@test.com, yyy@test.com, zzz@test.com" },
  {).collect(Collectors.toMap(data->data[0], data->data[1]));

  public static void main(String[] args) throws Exception {
    String MERGE_REQUEST_URL = GITLAB_URL + "/merge_requests?scope=all&state=opened&author_id=" + AUTHOR_ID;
    
    //STEP-1 : WebHook이 보내준 정보를 이용해서 GitLab 에서 진행중인 MR목록을 가져온다.
    String mrList = getMergeReqeustList(MERGE_REQUEST_URL);
    
  
  }

}
