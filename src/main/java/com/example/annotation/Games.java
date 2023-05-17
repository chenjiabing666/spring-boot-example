package com.example.annotation;

/*
 *  @ author  zengqingfa
 *  @ created in    2020/3/7  20:51
 *
 */

/**
 * 一个人喜欢玩游戏，他喜欢玩英雄联盟，绝地求生，极品飞车，尘埃4等，则我们需要定义一个人的注解，他属性代表喜欢玩游戏集合，一个游戏注解，游戏属性代表游戏名称
 */

import sun.awt.SunHints;

import java.lang.annotation.*;

/**玩家注解*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Games {
    Game[] value();
}

/**游戏注解*/
@Repeatable(Games.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Game {
    String value() default "";
}

/**玩游戏类*/
@Game(value = "LOL")
@Game(value = "PUBG")
@Game(value = "NFS")
@Game(value = "Dirt4")
class PlayGame {

}


@Games({@Game(value = "game1"),@Game(value = "game1")})
class PlayGame2 {

}


