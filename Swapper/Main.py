import os

for File in os.listdir(os.path.dirname(os.path.realpath(__file__)) + "/Source/"):
    print(f"Rescrambling {File}")

    