            package com.DiverPlan;

            public class SingleModeGroup {
                NDLStore singleNDL=new NDLStore();

                public void Case2(int depth, int time){
                    int rounded=  singleNDL.checkDepth(depth);
                    new ShowPressure(rounded,time);
                }
                public void Case1(int depth){

                  int rounded=  singleNDL.checkDepth(depth);
                  new ShowNDL(rounded);
                }
            }
