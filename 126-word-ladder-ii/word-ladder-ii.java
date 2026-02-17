class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) return result;
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        
        boolean found = false;
        
        while (!currentLevel.isEmpty() && !found) {
            
            wordSet.removeAll(currentLevel);
            Set<String> nextLevel = new HashSet<>();
            
            for (String word : currentLevel) {
                char[] arr = word.toCharArray();
                
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);
                        
                        if (wordSet.contains(newWord)) {
                            
                            nextLevel.add(newWord);
                            
                            map.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                            
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    
                    arr[i] = original;
                }
            }
            
            currentLevel = nextLevel;
        }
        
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, map, path, result);
        }
        
        return result;
    }
    
    private void dfs(String word, String beginWord, 
                     Map<String, List<String>> map,
                     List<String> path,
                     List<List<String>> result) {
        
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }
        
        if (!map.containsKey(word)) return;
        
        for (String parent : map.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, map, path, result);
            path.remove(path.size() - 1);
        }
    }
}
