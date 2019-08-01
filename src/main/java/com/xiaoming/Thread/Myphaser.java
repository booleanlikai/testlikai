package com.xiaoming.Thread;

import java.util.concurrent.Phaser;

public class Myphaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return this.studentArrived();
            case 1:
                return this.studentFirstExercise();
            case 2:
                return this.studentSecondExercise();
            case 3:
                return this.studentThridExercise();
        }
        return super.onAdvance(phase, registeredParties);
    }

    private boolean studentArrived() {
        System.out.println("学生准备好了学生人数：" + getRegisteredParties());
        return false;
    }

    private boolean studentFirstExercise() {
        System.out.println("第一题所有学生完成了：");
        return false;
    }

    private boolean studentSecondExercise() {
        System.out.println("第二题所有学生完成了：");
        return false;
    }


    private boolean studentThridExercise() {
        System.out.println("第三题所有学生完成了：");
        return false;
    }
}
