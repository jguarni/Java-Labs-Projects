import unittest

print(5 + 10)

LBS_TO_KILO = 0.45359237
print(175 * LBS_TO_KILO)

age = 19
print(age)
age = age + 1
print(age)

JOE_AGE = 25
if JOE_AGE < 18:
  print("minor")
elif JOE_AGE < 65:
  print("adult")
else:
  print("senior")

def celsius_to_fahrenheit(cdeg):
  return 32.0 + (cdeg * 1.8)
print(celsius_to_fahrenheit(25.0))

class TestTransition(unittest.TestCase):
  def test_celsius_to_fahrenheit(self):
    self.assertEqual(celsius_to_fahrenheit(25.0), 77.0)

#definite loop
total = 0
for x in range(10):
    total = total + x
print(total)

import random
guess = 1
while guess % 7 != 0:
    guess = random.randint(0, 99)
print(guess)

def root(n, start, end, base):
    if end <= start:
        return int(start)
    else:
        mid = int((end + start) / 2)
        guess = mid ** base
        if guess < n:
            return root(n, mid + 1, end, base)
        elif guess > n:
            return root(n, start, mid, base)
        else:
            return mid
print(root(16, 0, 16, 2))
print(root(24, 0, 24, 2))

class xyvector:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def midpoint(self):
        return xyvector(self.x / 2, self.y / 2)
    def magnitude(self):
        return (self.x ** 2 + self.y ** 2) ** .5
    def __str__(self):
        return "xyvector(" + str(self.x) + ", " + str(self.y) + ")"
    
SAMPLE_XY = xyvector(10.0, 24.0)
print(SAMPLE_XY.midpoint())
print(SAMPLE_XY.magnitude())


if __name__ == '__main__':
    unittest.main(verbosity=2,exit=False)
