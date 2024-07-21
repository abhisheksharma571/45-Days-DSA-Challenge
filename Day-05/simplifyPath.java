// Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.

// In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.

// The simplified canonical path should adhere to the following rules:

// It must start with a single slash '/'.
// Directories within the path should be separated by only one slash '/'.
// It should not end with a slash '/', unless it's the root directory.
// It should exclude any single or double periods used to denote current or parent directories.
// Return the new path.

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        //Split the input path by the slash '/' to get individual components.
        String[] components = path.split("/");

        for(String component : components){
            //If the component is "" (empty string) or ".", we skip it.
            if(component.equals("") || component.equals(".")) continue;
            //If the component is "..", we pop the stack (go up one level), if the stack is not empty.
            else if(component.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            //For other valid directory names, we push them onto the stack.
            else stack.push(component);
        }
        //After processing all components, we construct the simplified path from the stack.
        StringBuilder simplifiedPath = new StringBuilder();
        for(String dir : stack){
            simplifiedPath.append("/").append(dir);
        }
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
 