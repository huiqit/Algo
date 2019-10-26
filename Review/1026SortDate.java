/*
input format: 16 Oct 1994
day: 0-31 digit
month: Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
year: 4 digits
*/

class Solution {
  public List<String> sortDate(List<String> dates) {
    List<String> res = new ArrayList<>();
    if(dates == null || dates.size() == 0) {
      return res;
    }
    Map<String, String> map = new TreeMap<>();
    for(Stirng str : dates) {
      String newStr = changeFormat(str);
      // assume no duplicates date in input
      map.put(newStr, str); // sort by new format, and get value return
    }
    return newArrayList<>(map.values());
  }
  private String changeFormat(String str) {
    StringBuilder sb = new StringBuilder();
    Map<String, String> map = new HashMap<>();
    map.put("Jan", "01");
    map.put("Feb", "02");
    map.put("Mar", "03");
    map.put("Apr", "04");
    map.put("May", "05");
    map.put("Jun", "06");
    map.put("Jul", "07");
    map.put("Aug", "08");
    map.put("Sep", "09");
    map.put("Oct", "10");
    map.put("Nov", "11");
    map.put("Dec", "12");
    // 16 Oct 1994
    // 012345678910
    sb.append(str.substring(7, 11)); //能不能不用substring? 
    sb.append(str.substring(3, 6));
    sb.append(str.substring(0, 2));
    return sb.toString();
  }
}


