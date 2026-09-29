class Solution {
  public boolean isAnagram(String s, String t) {
    int[] abc = new int[26];

    if (s.length() != t.length())
      return false;
    
    for (int i = 0; i < s.length(); i++) {
      abc[s.charAt(i)-'a']++;
      abc[t.charAt(i)-'a']--;
    }
    for (int n : abc) {
      if (n != 0)
        return false;
    }
    return true;
  }
}
