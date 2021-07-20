"""
https://www.codewars.com/kata/60ca2ce44875c5004cda5c74/train/python
Context
In Dungeons and Dragons, a tabletop roleplaying game,
movement is limited in combat.
Characters can only move a set amount of distance per turn, meaning the distance you travel is very important.

In the 5th edition of the rulebook, the board is commonly organized into a grid,
but for ease of counting, movement is non-euclidian.
Each square is 5 ft, and moving diagonally counts the same as moving in a cardinal direction.

+------------------------+
| 10 | 10 | 10 | 10 | 10 |
+------------------------+
| 10 |  5 |  5 |  5 | 10 |
+------------------------+
| 10 |  5 | :) |  5 | 10 |
+------------------------+
| 10 |  5 |  5 |  5 | 10 |
+------------------------+
| 10 | 10 | 10 | 10 | 10 |
+------------------------+
Distance of each grid cell from the player, in feet
Your task
Create an algorithm to calculate the distance of a movement path.
You will be provided with the path as a series of absolute grid points (x, y, z).
Take in to account both horizontal (x, y) as well as vertical (z) movement.
Vertical movement is governed by the same rules, for the sake of simplicity.
"""
from typing import List, Tuple


def non_euclid_dist(start: Tuple[float, float, float], end: Tuple[float, float, float]):
    dif = [abs(x_1 - x_2) for x_1, x_2 in zip(start, end)]
    non_diagonal_movements = min(abs(dif[0] - dif[1] - dif[2]),
                             abs(dif[1] - dif[0] - dif[2]),
                             abs(dif[2] - dif[1] - dif[0]))
    return int((sum(
        dif) - non_diagonal_movements)) + non_diagonal_movements


def calc_distance(path: List[Tuple[float, float, float]]):
    distance: int = 0
    for i in range(len(path) - 1):
        distance += 5 * non_euclid_dist(path[i], path[i + 1])
    return distance
