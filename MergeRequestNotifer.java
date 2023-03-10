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
    
    //STEP-2 : MR 목록에서 WebHook 정보와 일치하는 리뷰건을 찾고 Reviewer ID 를 가져온다.
    String reviewerId = getReviewerId(mrList);
    
    //STEP-3 : reviewerId에 맵핑된 리뷰어 그룹에게 mail을 보내어 코드리뷰를 수행하도록 Noti한다.
    sendMail(reviewerId);
  }
   
  private static void sendMail(String reviewerId) {
    String reviewers = maillingList.get(reviewerId);
    
    for( String mailId : reviwers.split(",")) {
      System.out.println("reviewer_group :: " + reviwerId + ", sending mailg to= " _ maildId.trim()); 
    }
  }
   
   
  private static String getReviewerId(String mrList) {
    String reviewerId = "";
    List<Map<String, String>> list = JsonPath.read(mrList, "$");
    
    for( Map map : list) {
      List<Map> reviewerList = (List)map.get("reviewers");
      Map<String, String> reviewerMap = reviewerList.get(0);
      reviewerId = reviewerMap.get("username");
      break;
    }
    return reviewerId;
  }

   
  private static String getMergeRequestList(String merge_request_url) throws Exception {
    return Jsoup.connect(merge_request_url)
            .header("Content-Type", "application/json")
            .header("PRIVATE_TOKEN", GITLAB_API_PRIVATE_KEY)
            .ignoreContentType(true)
            .execute()
            .body();
  }
}
