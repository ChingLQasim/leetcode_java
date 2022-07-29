package Others;

/*
字符串匹配算法:
Sunday算法和BM算法稍有不同的是，Sunday算法是从前往后匹配，在匹配失败时关注的是主串中参加匹配的最末位字符的下一位字符。
    · 如果该字符没有在模式串中出现则直接跳过，即移动位数 = 模式串长度 + 1；
    · 否则，其移动位数 = 模式串长度 - 该字符最右出现的位置(以0开始) = 模式串中该字符最右出现的位置到尾部的距离 + 1。
 */
public class Sunday {
    public int sunday(char[] str, char[] model){
        int str_len = str.length, model_len = model.length;
        int[] move = new int[128];
        for (int i = 0; i < 128; i++) {
            move[i] = model_len + 1;
        }
        for (int i = 0; i < model_len; ++i){
            move[model[i]] = model_len - i;
        }
        int model_start = 0, model_match = 0;
        while(model_start <= str_len - model_len){
            model_match = 0;
            while (str[model_start + model_match] == model[model_match]){
                model_match ++;
                if (model_match > model_len){
                    return model_start;
                }
            }
            model_start += move[str[model_start + model_len]];
        }
        return -1;
    }
}
