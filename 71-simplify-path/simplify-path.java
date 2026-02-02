import java.util.*;

class Solution {

    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                // ignore
                continue;
            }

            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.removeLast());
        }

        return result.toString();
    }
}
