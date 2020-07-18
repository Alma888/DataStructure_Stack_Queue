package Stack;

//有效的括号——栈实现
//题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：左括号必须用相同类型的右括号闭合。
//                  左括号必须以正确的顺序闭合。
//                  注意空字符串可被认为是有效字符串。
//
//示例 1:
//输入: "()"
//输出: true
//示例 2:
//输入: "()[]{}"
//输出: true
//示例 3:
//输入: "(]"
//输出: false
//示例 4:
//输入: "([)]"
//输出: false
//示例 5:
//输入: "{[]}"
//输出: true

import java.util.Stack;

//有效的括号
public class IsValidBrackets {
    //【解题思路】：遍历字符串中的每个字符
    //                 如果是左括号：入栈
    //                如果是右括号：
    //                    若栈是空的：则不匹配（则右括号多了）  }}}}
    //                    出栈
    //                    如果左右括号不匹配：则不匹配    (} (}
    //                    否则继续循环
    //                如果栈不为空：则不匹配（右括号多）   {{{{
    //                否则匹配

    //【复杂度分析】：时间复杂度O(n)  空间复杂度O(n)
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);
                    if (!((left == '(' && c == ')') ||
                            (left == '[' && c == ']') ||
                            (left == '{' && c == '}'))) {
                        return false;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
