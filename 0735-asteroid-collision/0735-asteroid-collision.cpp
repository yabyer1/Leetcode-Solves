class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> RS;
        vector<int> ans;
        for(int i = 0;i < asteroids.size(); i++){
            if(asteroids[i] > 0){
                RS.push(asteroids[i]);
            }
            else{
                if(RS.empty() || RS.top() < 0){
                    RS.push(asteroids[i]);
                }
                else{
                    bool flag = true;
                    while(!RS.empty() && RS.top() > 0){
                            if(abs(asteroids[i]) > RS.top()){
                                RS.pop();

                            }
                            else if(abs(asteroids[i]) == RS.top()){
                                RS.pop();
                                flag = false;
                                break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                    }
                    if(flag){
                        RS.push(asteroids[i]);
                    }
                }
            }
        }
        while(!RS.empty()){
            ans.push_back(RS.top());
            RS.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};