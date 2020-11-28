import json
from json import dump
from pathlib import Path


def main():
    """
    main関数です
    """
    path = Path.cwd()/"src/main/resources/StrangeTable.json"
    with open(path, 'r') as f:
        sorted_dict: list[dict] = sorted(
            json.load(f), key=lambda x: x['before'])
        dumped_json = json.dumps(sorted_dict, indent=0, ensure_ascii=False)
        
    with open(path, 'w') as f:
        f.writelines(dumped_json)


if __name__ == "__main__":
    main()
