import json
import random


def deal1():
    # random.random
    f = open("C:/Users/asus/PycharmProjects/DataMining/CC/occupations.json", encoding='utf-8')
    occ = json.load(f)['occupations']
    # print(occ)
    typeof = ["agricultural", "intel", "battle", "social", "medic"]
    result = {}
    output = {}
    for o in occ:
        result[o] = ["5", "5", "5", "5", "5"]
    for o in occ:
        if "main" in o:
            result[o][0] += "+2d6"
            result[o][1] += "+2d6"
            result[o][2] += "+2d6"
            result[o][3] += "+2d6"
            result[o][4] += "+2d6"
        if "aerospace" in o:
            result[o][0] += "+3d6"
            result[o][1] += "+3d6"
            result[o][2] += "+3d6"
            result[o][3] += "+3d6"
            result[o][4] += "+3d6"
        if "detective" in o:
            result[o][0] += "+3d6"
            result[o][1] += "+3d6"
            result[o][2] += "+3d6"
            result[o][3] += "+3d6"
            result[o][4] += "+3d6"
        if "agricultural" in o or "farm" in o:
            result[o][0] += "+3d6"
        if "food" in o:
            result[o][0] += "+2d6"
        if "plant" in o:
            result[o][0] += "+1d6"
        if "scien" in o or "research" in o or "math" in o or "ologist" in o:
            result[o][1] += "+3d6"
        if "engineer" in o or "mechanic" in o or "tech" in o:
            result[o][1] += "+2d6"
        if "teacher" in o:
            result[o][1] += "+1d6"
            result[o][3] += "+2d6"
        if "soldier" in o or "escort" in o:
            result[o][2] += "+3d6"
        if "police" in o or "criminal" in o or "forest" in o or "hunter" in o or "safety" in o:
            result[o][2] += "+2d6"
        # if "" in o:
        #     result[o][2] += "+1d6"
        if "psych" in o or "mental" in o or "social" in o or "law" in o:
            result[o][3] += "+3d6"
        if "sale" in o or "interviewer" in o or "custom" in o or "sale" in o:
            result[o][3] += "+2d6"
        if "medic" in o or "surgeon" in o or "nurse" in o or "physician" in o or "clinical" in o:
            result[o][4] += "+3d6"
        if "health" in o or "therapist" in o or "life" in o:
            result[o][4] += "+2d6"

    for o in result:
        if result[o] != result['actor']:
            output[o] = result[o]

    # occ = {}
    # occ["occupations"] = output
    # print(type(occ))

    with open("C:/Users/asus/PycharmProjects/DataMining/CC/1.json", "w+") as d:
        # for o in output:
        json.dump(output, d)


def deal2():
    bodyPartStatus = {
        "bodyPartStatus": {
            0: {
                    "name": "health",
                    "detail": "{name} is bleeding, looks bad.",
                    "time": 999,
                    "GoodOrBad": "good"
                },
            1: {
                    "name": "bleeding",
                    "detail": "{name} is bleeding, looks bad.",
                    "time": 3,
                    "GoodOrBad": "bad"
                },
            2: {
                    "name": "injured",
                    "detail": "{name} is injured, looks not really good.",
                    "time": 3,
                    "GoodOrBad": "bad"
                },
            3: {
                    "name": "gunshot",
                    "detail": "{name} is hurt by a bullet.",
                    "time": 4,
                    "GoodOrBad": "bad"
                },
            4: {
                    "name": "cut",
                    "detail": "{name} is hurt by a blade.",
                    "time": 3,
                    "GoodOrBad": "bad"
                },
            5: {
                    "name": "Bruise",
                    "detail": "an injury appearing as an area of discolored skin on the {name}",
                    "time": 3,
                    "GoodOrBad": "bad"
                },
        }
    }

    CharacterStatus = {
        "CharacterStatus": {
            0: {
                "name": "Normal",
                "detail": "{name} looks good.",
                "time": 999,
                "GoodOrBad": "normal"
            },
            1: {
                "name": "painful",
                "detail": "{name} looks uncomfortable, and is suffering from pain.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            2: {
                "name": "injured",
                "detail": "{name} is injured and looks a little inconvenient.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            3: {
                "name": "shock",
                "detail": "{name} lost consciousness and life is in danger.",
                "time": 999,
                "GoodOrBad": "bad"
            },
            4: {
                "name": "coma",
                "detail": "{name} fainted. But {name} does not appear to have obvious trauma.",
                "time": 3,
                "GoodOrBad": "bad"
            }
        }
    }

    GoodMood = {
        "GoodMoods": {
            0: {
                "name": "Normal",
                "detail": "{name} 's mood is calm, nothing special.",
                "time": 999,
                "GoodOrBad": "normal"
            },
            1: {
                "name": "relax",
                "detail": "{name} 's mood is relaxed, and the pressure seems to be lessened.",
                "time": 3,
                "GoodOrBad": "good"
            },
            2: {
                "name": "comfort",
                "detail": "{name} feels comfortable and forgets a lot of troubles.",
                "time": 3,
                "GoodOrBad": "good"
            },
            3: {
                "name": "happy",
                "detail": "{name} feels good after that and in a better mood.",
                "time": 3,
                "GoodOrBad": "good"
            },
            4: {
                "name": "peace",
                "detail": "{name} 's mood has calmed down a lot, and fear has left {name}.",
                "time": 3,
                "GoodOrBad": "good"
            },
            5: {
                "name": "peace",
                "detail": "{name} is calm, and what ’s happening around does n’t affect {name}.",
                "time": 3,
                "GoodOrBad": "good"
            },
            6: {
                "name": "excited",
                "detail": "{name} is very excited, he seems to have endless energy.",
                "time": 3,
                "GoodOrBad": "good"
            },
            7: {
                "name": "confident",
                "detail": "{name} is very confident, it seems that there is nothing that {name} cannot do in this world.",
                "time": 3,
                "GoodOrBad": "good"
            },
            8: {
                "name": "optimistic",
                "detail": "{name} is very optimistic, he believes things will go to a good place.",
                "time": 3,
                "GoodOrBad": "good"
            },
            9: {
                "name": "cool",
                "detail": "{name} feels very cool, like living in heaven.",
                "time": 3,
                "GoodOrBad": "good"
            }
        }
    }

    BadMood = {
        "BadMoods": {
            0: {
                "name": "Normal",
                "detail": "{name} 's mood is calm, nothing special.",
                "time": 999,
                "GoodOrBad": "normal"
            },
            1: {
                "name": "irritable",
                "detail": "{name} is very irritable, and it's hard to do one thing quietly.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            2: {
                "name": "uncomfortable",
                "detail": "{name} {name} is uncomfortable, as if bound by something.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            3: {
                "name": "sad",
                "detail": "{name} is very sad, sitting alone in the corner and crying.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            4: {
                "name": "anxious",
                "detail": "{name} is so anxious that {name} keeps walking around.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            5: {
                "name": "panic",
                "detail": "{name} is in panic, and fear and helplessness gradually made him crazy.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            6: {
                "name": "frustrate",
                "detail": "{name} is very frustrated, it seems to have no spirit.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            7: {
                "name": "inferior",
                "detail": "{name} is inferior, and {human} has no confidence at all.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            8: {
                "name": "pessimistic",
                "detail": "{name} is pessimistic, and {name} thinks that there will always be bad things happening.",
                "time": 3,
                "GoodOrBad": "bad"
            },
            9: {
                "name": "desperate",
                "detail": "{name} feels desperate, and {name} thinks he lives in hell.",
                "time": 3,
                "GoodOrBad": "bad"
            }
        }
    }

    BadRelation = {
        "BadRelations": {
            0: {
                "name": "Normal",
                "detail": "{name} 's mood is calm, nothing special.",
                "time": 999,
                "GoodOrBad": "normal"
            },
            1: {
                "name": "dislike",
                "detail": "{name1} doesn't like {name2}, this person is around to make {name1} unpleasant.",
                "time": 999,
                "GoodOrBad": "bad"
            },
            2: {
                "name": "hate",
                "detail": "{name1} hates {name2} and seeing {name2} makes {name1} sick.",
                "time": 999,
                "GoodOrBad": "bad"
            },
            3: {
                "name": "hostile",
                "detail": "{name1} regards {name2} as an enemy, and if they do not restrain themselves, they may fight.",
                "time": 999,
                "GoodOrBad": "bad"
            },
            4: {
                "name": "contempt",
                "detail": "{name1} feels that {name2} is rubbish and is not worth communicating.",
                "time": 999,
                "GoodOrBad": "bad"
            },
            5: {
                "name": "ex",
                "detail": "{name1} and {name2} used to be very close, but at this time they are like strangers.",
                "time": 999,
                "GoodOrBad": "bad"
            },
        }
    }

    GoodRelation = {
        "GoodRelations": {
            0: {
                "name": "Normal",
                "detail": "{name1} and {name2} are almost strangers, nothing special.",
                "time": 999,
                "GoodOrBad": "normal"
            },
            1: {
                "name": "friend",
                "detail": "{name1} and {name2} are the relationship of friends. The two people think that the other is worth communicating with.",
                "time": 999,
                "GoodOrBad": "good"
            },
            2: {
                "name": "good friend",
                "detail": "{name1} and {name2} are good friends. They are quite familiar with each other and are in harmony.",
                "time": 999,
                "GoodOrBad": "good"
            },
            3: {
                "name": "best friend",
                "detail": "{name1} and {name2} are one of each other ’s best friends, and they are completely open to each other.",
                "time": 999,
                "GoodOrBad": "good"
            },
            4: {
                "name": "benefactor",
                "detail": "{name1} was saved by {name2}, so {name1} has always been grateful.",
                "time": 999,
                "GoodOrBad": "good"
            },
            5: {
                "name": "admire",
                "detail": "{name1} admires {name2} and {name1} believes that {name2} is trustworthy and dependable.",
                "time": 999,
                "GoodOrBad": "good"
            },
            6: {
                "name": "love",
                "detail": "{name1} and {name2} love each other deeply, and they agree to be together until the end of life.",
                "time": 999,
                "GoodOrBad": "good"
            },
        }
    }
    # to_json(bodyPartStatus, 'bodyPartStatus')
    # to_json(CharacterStatus, 'CharacterStatus')
    # to_json(GoodMood, 'GoodMood')
    # to_json(BadMood, 'BadMood')
    to_json(GoodRelation, 'GoodRelation')
    to_json(BadRelation, 'BadRelation')


def deal3():

    temp = "{name} set off with a weapon, ready to find prey that can be captured."

    outerDescription = [
        "{name} search around the base, trying to find some plants eatable",
        "{name} is hanging around in the nearby woods, trying to find something to eat.",
    ]

    innerDescription_0 = [
        "{name} found nothing, and accidentally dropped the food that he carried with him.",
        "{name} found a lot of colorful mushrooms. Although it was obvious that these mushrooms could not be eaten, {name} packed them in his pocket and contaminated some food.",
        "{name} had been searching for a long time and accidentally lost his way, so that he consumed more food before returning to the base."
    ]

    innerDescription_1 = [
        "{name} searched for a long time but found nothing.",
        "{name} was lazy on the way, sleeping secretly on the grass for a long time, and finally found nothing.",
        "{name} heard some dangerous beast growls. Finally, {name} decides not to take risks and returns first."
    ]

    innerDescription_2 = [
        "{name} found some {food} and brought them back.",
        "{name} stumbled upon some {food} on the road and put them into the backpack.",
        "After {name} 's efforts, some {food} was harvested."
    ]
    innerDescription_3 = [
        "{name} was lucky, he saw a lot of {food} along the way, and finally returned with a full load.",
        "{name} found a lot of {food} in a secret place, these {food} can be eaten for a long time.",
        "{name} got lost on the way to find food, but found many {food} in the accident, and finally {name} successfully brought them all back."
    ]

    outerDescription_h = [
        "{name} search around with a rifle, trying to hunt some preys.",
        "{name} set off with a weapon, ready to find prey that can be captured.",
    ]

    innerDescription_h_0 = [
        "{name} found a {animal}, But no matter how many shots {name} shot, {name} couldn't hit the target.",
        "{name} found a {animal}, but the {animal} was irritated after the shot, and {name} had to run away quickly.",
        "{name} Try to find prey. {name} found an {animal}, but when {name} was about to fire, {name} found that the gun was malfunctioning and had no choice but to return to repair the gun."
    ]
    innerDescription_h_1 = [
        "{name} found a {animal}. But {name} didn't hit the target when shooting, and {animal} escaped.",
        "{name} found the trace of {animal}s. But after searching for a long time, {name} still couldn't find it, and finally had to give up and return.",
        "{name} found a large group of {animal}s trails. After thinking about it, {name} thought it was dangerous for someone to try to hunt so many {animal}s, so {name} returned."
    ]
    innerDescription_h_2 = [
        "{name} successfully caught a {animal} and returned with it.",
        "{name} hunted a {animal} in one shot and obtained some fresh meat.",
        "{name} planted a simple trap and caught a {animal}. {name} brought it back."
    ]
    innerDescription_h_3 = [
        "{name} 's shooting accuracy is very high today. He successfully hunted several {animal} and got a lot of meat.",
        "{name} encountered several injured and incapable {animal}s. {name} killed them without hesitation and brought the meat back.",
        "Following the trail of {animal}s, {name} found their lair and wiped out all the {animal}s."
    ]

    agri = {}
    # animal = 0
    # vege = 0
    i = 0
    f1 = open("C:/Users/asus/PycharmProjects/DataMining/CC/vegetables.json", encoding="utf-8")
    f2 = open("C:/Users/asus/PycharmProjects/DataMining/CC/common.json", encoding="utf-8")
    vege = json.load(f1)
    animal = json.load(f2)
    agri["gather"] = {}
    agri["hunter"] = {}
    for v in vege["vegetables"]:
        agri["gather"][i] = {}
        agri["gather"][i]["eventdescription"] = outerDescription
        agri["gather"][i]["target"] = v
        agri["gather"][i]["object"] = 1
        agri["gather"][i]["subject"] = 0

        agri["gather"][i]["0"] = {}
        agri["gather"][i]["0"]['resultdescription'] = innerDescription_0
        agri["gather"][i]["0"]['type'] = "food"
        agri["gather"][i]["0"]['goodorbad'] = "bad"
        agri["gather"][i]["0"]['motivate'] = "bad gather job"
        agri["gather"][i]["0"]['influence'] = "1d6"

        agri["gather"][i]["1"] = {}
        agri["gather"][i]["1"]['resultdescription'] = innerDescription_1
        agri["gather"][i]["1"]['type'] = "food"
        agri["gather"][i]["1"]['goodorbad'] = "bad"
        agri["gather"][i]["1"]['motivate'] = "bad gather job"
        agri["gather"][i]["1"]['influence'] = "1"

        agri["gather"][i]["2"] = {}
        agri["gather"][i]["2"]['resultdescription'] = innerDescription_2
        agri["gather"][i]["2"]['type'] = "food"
        agri["gather"][i]["2"]['goodorbad'] = "good"
        agri["gather"][i]["2"]['motivate'] = ""
        agri["gather"][i]["2"]['influence'] = "1d6"

        agri["gather"][i]["3"] = {}
        agri["gather"][i]["3"]['resultdescription'] = innerDescription_3
        agri["gather"][i]["3"]['type'] = "food"
        agri["gather"][i]["3"]['goodorbad'] = "good"
        agri["gather"][i]["3"]['motivate'] = "outstanding gather job"
        agri["gather"][i]["3"]['influence'] = "2d6"

        i += 1

    i = 0

    for v in animal["animals"]:
        agri["hunter"][i] = {}
        agri["hunter"][i]["eventdescription"] = outerDescription_h
        agri["hunter"][i]["target"] = v
        agri["hunter"][i]["object"] = 1
        agri["hunter"][i]["subject"] = 0

        agri["hunter"][i]["0"] = {}
        agri["hunter"][i]["0"]['resultdescription'] = innerDescription_h_0
        agri["hunter"][i]["0"]['type'] = "food"
        agri["hunter"][i]["0"]['goodorbad'] = "bad"
        agri["hunter"][i]["0"]['motivate'] = "bad hunter job"
        agri["hunter"][i]["0"]['influence'] = "1d6"

        agri["hunter"][i]["1"] = {}
        agri["hunter"][i]["1"]['resultdescription'] = innerDescription_h_1
        agri["hunter"][i]["1"]['type'] = "food"
        agri["hunter"][i]["1"]['goodorbad'] = "bad"
        agri["hunter"][i]["1"]['motivate'] = "bad hunter job"
        agri["hunter"][i]["1"]['influence'] = "1"

        agri["hunter"][i]["2"] = {}
        agri["hunter"][i]["2"]['resultdescription'] = innerDescription_h_2
        agri["hunter"][i]["2"]['type'] = "food"
        agri["hunter"][i]["2"]['goodorbad'] = "good"
        agri["hunter"][i]["2"]['motivate'] = ""
        agri["hunter"][i]["2"]['influence'] = "1d6"

        agri["hunter"][i]["3"] = {}
        agri["hunter"][i]["3"]['resultdescription'] = innerDescription_h_3
        agri["hunter"][i]["3"]['type'] = "food"
        agri["hunter"][i]["3"]['goodorbad'] = "good"
        agri["hunter"][i]["3"]['motivate'] = "outstanding hunter job"
        agri["hunter"][i]["3"]['influence'] = "2d6"
        i += 1

    i = 0
    skillevent = {
        "skills":
            {
                "agri":
                    {
                        0: {
                            "description": "xxx",  # 对于事件的描述
                            "object": "1",  # 主语人物
                            "subject": "0",  # 宾语人物
                            0: {
                                "goodorbad": "bad",  # 此等级是好是坏
                                "type": "food",  # 影响的参数
                                "describe": "xxx",  # 此成功等级的描述
                                "influence": "1d6"  # 造成影响的具体数值
                            },
                            1: {
                                "goodorbad": "bad",  # 此等级是好是坏
                                "type": "food",  # 影响的参数
                                "describe": "xxx",  # 此成功等级的描述
                                "influence": "1d6"  # 造成影响的具体数值
                            },
                            2: {
                                "goodorbad": "bad",  # 此等级是好是坏
                                "type": "food",  # 影响的参数
                                "describe": "xxx",  # 此成功等级的描述
                                "influence": "1d6"  # 造成影响的具体数值
                            },
                            3: {
                                "goodorbad": "bad",  # 此等级是好是坏
                                "type": "food",  # 影响的参数
                                "describe": "xxx",  # 此成功等级的描述
                                "influence": "1d6"  # 造成影响的具体数值
                            },
                        },
                        1: {},
                        2: {},

                    }
            },
    }
    to_json(agri, "Agri_event")


def deal4():
    medic = {}
    medic["first_aid"] = {
        "description": "",
        "object": 1,
        "subject": 1,
        0: {
            "resultdescription": "{name1} wants to give first aid to {name2}, but the treatment of {name1} has not been effective, but has aggravated {name2} 's injury.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1} caused a medical incident to {name2}.",
            'influence': "1d5"
        },
        1: {
            "resultdescription": "{name1} wants to give first aid to {name2}, but the treatment for {name1} has not worked.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1}'s Failed treatment to {name2}",
            'influence': "0"
        },
        2: {
            "resultdescription": "{name1} successfully treated {name2}, {name2} looks better",
            "type": "HP",
            "goodorbad": "good",
            'motivate': "{name1} successfully treated {name2}",
            'influence': "1d5"
        },
        3: {
            "resultdescription": "{name1} performed extremely effective treatment on {name2}, and {name2} hardly sees any injuries.",
            "type": "HP",
            "goodorbad": "good",
            'motivate': "{name1} successfully treated {name2}",
            'influence': "5"
        },
    }

    to_json(medic, 'medic_event')


def deal5():
    battle = {}
    battle["fire"] = {
        "description": "",
        "object": 1,
        "subject": 1,
        0: {
            "resultdescription": "{name1} used {weapon} to fire at {name2}, but the bullet failed to hit the target.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1} missed {name2} while shooting.",
            'influence': "0"
        },
        1: {
            "resultdescription": "{name1} used {weapon} to fire at {name2}, but the bullet failed to hit the target.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1} missed {name2} while shooting.",
            'influence': "0"
        },
        2: {
            "resultdescription": "{name1} used {weapon} to fire on {name2} and the bullet accurately hit the target.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1} successfully hit {name2}",
            'influence': "1d5"
        },
        3: {
            "resultdescription": "{name1} performed extremely effective treatment on {name2}, and {name2} hardly sees any injuries.",
            "type": "HP",
            "goodorbad": "bad",
            'motivate': "{name1} successfully killed {name2}",
            'influence': "10"
        },
    }
    to_json(battle, 'battle_event')


def deal6():
    research = {}
    research["research"] = {
        "description": "{name} decided to calm down and think about how to return to the civilized world.",
        "object": 1,
        "subject": 0,
        0: {
            "resultdescription": "{name} came up with an extremely bad idea, which took everyone one step further from victory.",
            "type": "INT",
            "goodorbad": "bad",
            'motivate': "{name}'s bad Idea",
            'influence': "1d6"
        },
        1: {
            "resultdescription": "{name} thought of a useless idea, which does not help everyone.",
            "type": "INT",
            "goodorbad": "bad",
            'motivate': "",
            'influence': "0"
        },
        2: {
            "resultdescription": "{name} came up with a good idea, which brought everyone closer to the civilized world.",
            "type": "INT",
            "goodorbad": "good",
            'motivate': "{name}'s good Idea",
            'influence': "1d6"
        },
        3: {
            "resultdescription": "{name} thought of a brilliant idea, which took everyone a big step forward.",
            "type": "INT",
            "goodorbad": "good",
            'motivate': "{name}'s brilliant Idea",
            'influence': "2d6"
        },
    }
    to_json(research, 'Int_event')


def deal7():

    innerDescription_0 = [
        "{name} found nothing, and accidentally dropped the food that he carried with him.",
        "{name} found a lot of colorful mushrooms. Although it was obvious that these mushrooms could not be eaten, {name} packed them in his pocket and contaminated some food.",
        "{name} had been searching for a long time and accidentally lost his way, so that he consumed more food before returning to the base."
    ]

    innerDescription_1 = [
        "{name} searched for a long time but found nothing.",
        "{name} was lazy on the way, sleeping secretly on the grass for a long time, and finally found nothing.",
        "{name} heard some dangerous beast growls. Finally, {name} decides not to take risks and returns first."
    ]

    innerDescription_2 = [
        "{name} found some {food} and brought them back.",
        "{name} stumbled upon some {food} on the road and put them into the backpack.",
        "After {name} 's efforts, some {food} was harvested."
    ]
    innerDescription_3 = [
        "{name} was lucky, he saw a lot of {food} along the way, and finally returned with a full load.",
        "{name} found a lot of {food} in a secret place, these {food} can be eaten for a long time.",
        "{name} got lost on the way to find food, but found many {food} in the accident, and finally {name} successfully brought them all back."
    ]

    innerDescription_h_0 = [
        "{name} found a {animal}, But no matter how many shots {name} shot, {name} couldn't hit the target.",
        "{name} found a {animal}, but the {animal} was irritated after the shot, and {name} had to run away quickly.",
        "{name} Try to find prey. {name} found an {animal}, but when {name} was about to fire, {name} found that the gun was malfunctioning and had no choice but to return to repair the gun."
    ]

    innerDescription_h_1 = [
        "{name} found a {animal}. But {name} didn't hit the target when shooting, and {animal} escaped.",
        "{name} found the trace of {animal}s. But after searching for a long time, I still couldn't find it, and finally had to give up and return.",
        "{name} found a large group of {animal}s trails. After thinking about it, {name} thought it was dangerous for someone to try to hunt so many {animal}s, so {name} returned."
    ]

    innerDescription_h_2 = [
        "{name} successfully caught a {animal} and returned with it.",
        "{name} hunted a {animal} in one shot and obtained some fresh meat.",
        "{name} planted a simple trap and caught a {animal}. {name} brought it back."
    ]
    innerDescription_h_3 = [
        "{name} 's shooting accuracy is very high today. He successfully hunted several {animal} and got a lot of meat.",
        "{name} encountered several injured and incapable {animal}s. {name} killed them without hesitation and brought the meat back.",
        "Following the trail of {animal}s, {name} found their lair and wiped out all the {animal}s."
    ]

    social = {}
    # animal = 0
    # vege = 0
    i = 0
    f1 = open("C:/Users/asus/PycharmProjects/DataMining/CC/encouraging_words.json", encoding="utf-8")
    f2 = open("C:/Users/asus/PycharmProjects/DataMining/CC/disencouraging_words.json", encoding="utf-8")
    enc = json.load(f1)
    dis = json.load(f2)
    social["good"] = {}
    social["bad"] = {}
    for v in enc["words"]:
        social["good"][i] = {}
        social["good"][i]["eventdescription"] = \
            "{name1} started a " \
            + v \
            + " conversation with {name2}, and the content of the talk was the {motivate}"
        social["good"][i]["object"] = 1
        social["good"][i]["subject"] = 1

        social["good"][i]["0"] = {}
        social["good"][i]["0"]['resultdescription'] = "Although the subject of the conversation was pleasant, the two did not have a pleasant conversation."
        social["good"][i]["0"]['type'] = "unity"
        social["good"][i]["0"]['goodorbad'] = "bad"
        social["good"][i]["0"]['motivate'] = "bad conversation"
        social["good"][i]["0"]['influence'] = "1d6"

        social["good"][i]["1"] = {}
        social["good"][i]["1"]['resultdescription'] = "Although the subject of the conversation was pleasant, they soon lost the topic."
        social["good"][i]["1"]['type'] = "unity"
        social["good"][i]["1"]['goodorbad'] = "bad"
        social["good"][i]["1"]['motivate'] = ""
        social["good"][i]["1"]['influence'] = "1"

        social["good"][i]["2"] = {}
        social["good"][i]["2"]['resultdescription'] = "The subject of the conversation was pleasant, and the two had been chatting for a long time, and they were very happy."
        social["good"][i]["2"]['type'] = "unity"
        social["good"][i]["2"]['goodorbad'] = "good"
        social["good"][i]["2"]['motivate'] = "good conversation"
        social["good"][i]["2"]['influence'] = "1d6"

        social["good"][i]["3"] = {}
        social["good"][i]["3"]['resultdescription'] = "The subject of the conversation was pleasant, and the two had a great conversation. They chatted for a long time before saying goodbye."
        social["good"][i]["3"]['type'] = "unity"
        social["good"][i]["3"]['goodorbad'] = "good"
        social["good"][i]["3"]['motivate'] = "great conversation"
        social["good"][i]["3"]['influence'] = "2d6"

        i += 1

    i = 0

    for v in dis["words"]:
        social["bad"][i] = {}
        social["bad"][i]["eventdescription"] = \
            "{name1} started a " \
            + v \
            + " conversation with {name2}, and the content of the talk was the {motivate}"
        social["bad"][i]["object"] = 1
        social["bad"][i]["subject"] = 1

        social["bad"][i]["0"] = {}
        social["bad"][i]["0"]['resultdescription'] = "The subject of the conversation was heavy, and the two had a bad conversation. The atmosphere between them is a bit bad."
        social["bad"][i]["0"]['type'] = "unity"
        social["bad"][i]["0"]['goodorbad'] = "bad"
        social["bad"][i]["0"]['motivate'] = "bad conversation"
        social["bad"][i]["0"]['influence'] = "1d6"

        social["bad"][i]["1"] = {}
        social["bad"][i]["1"]['resultdescription'] = "The subject of the conversation was heavy, and they failed to make progress."
        social["bad"][i]["1"]['type'] = "unity"
        social["bad"][i]["1"]['goodorbad'] = "bad"
        social["bad"][i]["1"]['motivate'] = ""
        social["bad"][i]["1"]['influence'] = "1"

        social["bad"][i]["2"] = {}
        social["bad"][i]["2"]['resultdescription'] = "The subject of the conversation was heavy, but they eased each other's emotions through chat."
        social["bad"][i]["2"]['type'] = "unity"
        social["bad"][i]["2"]['goodorbad'] = "good"
        social["bad"][i]["2"]['motivate'] = "good conversation"
        social["bad"][i]["2"]['influence'] = "1d6"

        social["bad"][i]["3"] = {}
        social["bad"][i]["3"]['resultdescription'] = "The subject of the conversation is heavy, but they seem to have reached a certain consensus and cleared the gloomy emotions."
        social["bad"][i]["3"]['type'] = "unity"
        social["bad"][i]["3"]['goodorbad'] = "good"
        social["bad"][i]["3"]['motivate'] = "great conversation"
        social["bad"][i]["3"]['influence'] = "2d6"
        i += 1

    i = 0
    to_json(social, "Social_event")


def deal8():
    f = open("C:/Users/asus/PycharmProjects/DataMining/CC/weather_conditions.json", encoding="utf-8")
    weather_load = json.load(f)
    weather = {"description": "",
               "object": 0,
               "subject": 0,
               "weather": {}}
    discribe = []
    for w in weather_load["conditions"]:
        discribe.append("Today's weather is: " + w + ".")
        discribe.append("Today is a new day with " + w + " outside.")

    random.shuffle(discribe)
    weather["weather"] = discribe
    to_json(weather, "Weather_event")


def deal9():
    newman = {}
    newman[1] = {}
    newman[1] = {
        "type": "newman",
        "newman": "lost",
        "panalty": "no",
        "value": "0",
        "description": "{name1} encountered a lost person {name2} while traveling, and after some simple communication, they decided to go together.",
        "object": 1,
        "subject": 1,
    }
    newman[2] = {}
    newman[2] = {
        "type": "newman",
        "newman": "injured",
        "panalty": "HP",
        "value": "1d3",
        "description": "{name1} encountered an injured person {name2} while traveling, and after a simple treatment, they decided to go together.",
        "object": 1,
        "subject": 1,
    }

    newman[3] = {}
    newman[3] = {
        "type": "newman",
        "newman": "hungry",
        "panalty": "food",
        "value": "1d5",
        "description": "{name1} encountered a hungry person {name2} while traveling, and {name1} shared some food. In the end they decided to go together.",
        "object": 1,
        "subject": 1,
    }

    newman[4] = {}
    newman[4] = {
        "type": "newman",
        "newman": "lost",
        "panalty": "no",
        "value": "0",
        "description": "{name1} met a traveler like him {name2} during the trip. After a brief conversation, they decided to go together.",
        "object": 1,
        "subject": 1,
    }

    newman[5] = {}
    newman[5] = {
        "type": "newman",
        "newman": "danger",
        "panalty": "no",
        "value": "0",
        "description": "{name1} encountered a {name2} who was being chased by a monster while traveling. {name1} shot at the unknown creature and turned away. Nowhere to go {name2} joined the team.",
        "object": 1,
        "subject": 1,
    }
    print(newman)
    to_json(newman, "Newman_event")


def deal10():
    nlist = json.load(open("C:/Users/asus/PycharmProjects/DataMining/CC/geographic_features_modified.json", encoding="utf-8"))
    nature = {}
    i = 1
    for v in nlist['entries']:
        nature[i] = {}
        nature[i]["decription"] = "The team moved forward, they passed a {place},".replace('{place}', v)
        nature[i]["object"] = "all"
        nature[i]["subject"] = 0

        nature[i][1] = {}
        nature[i][1]["decription"] = "{name} found something edible here."
        nature[i][1]["goodorbad"] = "good"
        nature[i][1]["type"] = "food"
        nature[i][1]["influence"] = "1d6"

        nature[i][2] = {}
        nature[i][2]["decription"] = "{name} looked at the scenery and thought it was really beautiful, and {name} felt comfortable."
        nature[i][2]["goodorbad"] = "good"
        nature[i][2]["type"] = "unity"
        nature[i][2]["influence"] = "1d6"

        nature[i][3] = {}
        nature[i][3]["decription"] = "{name} looked into the distance and found traces of buildings in the distance. This brings them one step closer to the civilized world."
        nature[i][3]["goodorbad"] = "good"
        nature[i][3]["type"] = "INT"
        nature[i][3]["influence"] = "1d6"

        nature[i][4] = {}
        nature[i][4]["decription"] = "{name} 's backpack was broken. After repairing, it was found that some of the contents disappeared."
        nature[i][4]["goodorbad"] = "bad"
        nature[i][4]["type"] = "food"
        nature[i][4]["influence"] = "1d6"

        nature[i][5] = {}
        nature[i][5]["decription"] = "{name} accidentally fell while watching the scenery and was slightly injured."
        nature[i][5]["goodorbad"] = "bad"
        nature[i][5]["type"] = "HP"
        nature[i][5]["influence"] = "1d2"

        nature[i][6] = {}
        nature[i][6]["decription"] = "{name} was accidentally scratched by prickly plants while watching the scenery, and was slightly injured."
        nature[i][6]["goodorbad"] = "bad"
        nature[i][6]["type"] = "HP"
        nature[i][6]["influence"] = "1d2"

        nature[i][7] = {}
        nature[i][7]["decription"] = "While watching the scenery, {name} suddenly felt that the road ahead was endless, and began to wonder if the team could reach the end."
        nature[i][7]["goodorbad"] = "bad"
        nature[i][7]["type"] = "unity"
        nature[i][7]["influence"] = "1d5"

        nature[i][8] = {}
        nature[i][8]["decription"] = "While watching the scenery, {name} suddenly didn't know where to go next."
        nature[i][8]["goodorbad"] = "bad"
        nature[i][8]["type"] = "INT"
        nature[i][8]["influence"] = "1d3"

        i += 1

    tlist = json.load(open("C:/Users/asus/PycharmProjects/DataMining/CC/norwegian_cities.json", encoding="utf-8"))
    for t in tlist["cities"]:
        nature[i] = {}
        nature[i]["decription"] = "The team moved forward, they arrived a town named {place},".replace('{place}', t["city"])
        nature[i]["object"] = "all"
        nature[i]["subject"] = 0

        nature[i][1] = {}
        nature[i][1]["decription"] = "After communicating with the townspeople, {name} got a lot of information about the nearby civilized world. This allows {name} to plan for the next route."
        nature[i][1]["goodorbad"] = "good"
        nature[i][1]["type"] = "INT"
        nature[i][1]["influence"] = "1d8"

        nature[i][2] = {}
        nature[i][2]["decription"] = "{name} went to the pub in the town. Fine wine makes {name} relax a lot, and the mood is much better."
        nature[i][2]["goodorbad"] = "good"
        nature[i][2]["type"] = "unity"
        nature[i][2]["influence"] = "1d6"

        nature[i][3] = {}
        nature[i][3]["decription"] = "{name} looked into the distance and found traces of buildings in the distance. This brings them one step closer to the civilized world."
        nature[i][3]["goodorbad"] = "good"
        nature[i][3]["type"] = "INT"
        nature[i][3]["influence"] = "1d6"

        nature[i][4] = {}
        nature[i][4]["decription"] = "{name} and helped the townspeople hunt a monster, and the townspeople rewarded them with food."
        nature[i][4]["goodorbad"] = "good"
        nature[i][4]["type"] = "food"
        nature[i][4]["influence"] = "1d8"

        nature[i][5] = {}
        nature[i][5]["decription"] = "{name} took a good rest in the town ’s hotel for a long time. A lot of physical strength was restored."
        nature[i][5]["goodorbad"] = "good"
        nature[i][5]["type"] = "HP"
        nature[i][5]["influence"] = "1d3"

        nature[i][6] = {}
        nature[i][6]["decription"] = "{name} somehow quarreled with the villagers in the town, and finally there was a fight, with some minor injuries"
        nature[i][6]["goodorbad"] = "bad"
        nature[i][6]["type"] = "HP"
        nature[i][6]["influence"] = "1d2"

        nature[i][7] = {}
        nature[i][7]["decription"] = "Several naughty children gave {name} a wrong map, so that when leaving the town {name} got in the wrong direction."
        nature[i][7]["goodorbad"] = "bad"
        nature[i][7]["type"] = "INT"
        nature[i][7]["influence"] = "1d3"

        nature[i][8] = {}
        nature[i][8]["decription"] = "{name} was spotted by a thief while wandering around the town, and some food was stolen."
        nature[i][8]["goodorbad"] = "bad"
        nature[i][8]["type"] = "food"
        nature[i][8]["influence"] = "1d3"
        i += 1
    # print(nature)
    to_json(nature, "Travel_event")


def to_json(dict, name):
    with open("C:/Users/asus/PycharmProjects/DataMining/CC/"+name+".json", "w+") as d:
        # for o in output:
        json.dump(dict, d)


# deal1()
# deal2()
deal3()
# deal4()
# deal5()
# deal6()
# deal7()
# deal8()
# deal9()
# deal10()