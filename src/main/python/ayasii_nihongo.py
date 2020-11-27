import json


def convert(s: str) -> str:
    with open("src/main/resources/StrangeTable.json") as f:
        json_load: list[dict] = json.load(f)

    # print(json_load)
    result = list(s)
    for i, c in enumerate(s):
        for item in json_load:
            if c == item['before']:
                result[i] = item['after']

    return ''.join(result)


def main() -> None:
    print(convert("怪しい日本語"))


if __name__ == "__main__":
    main()
