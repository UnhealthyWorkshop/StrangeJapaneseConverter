import json
from pathlib import Path

def write_json(path: Path, obj: dict) -> None:
    ls = None
    with open(path, 'r+') as f:
        ls = f.readlines()
        if ls == []:
            ls.append('[\n')
        if ls[-1] == ']':
            ls[-1] = ','
        ls.insert(len(ls), f'{json.dumps(obj, indent=1 ,ensure_ascii=False)}')
        ls.insert(len(ls), '\n]')

    with open(path, 'w') as f:
        f.writelines(ls)

def main():
    path = Path.cwd()/"src/main/resources/StrangeTable.json"
    s1, s2 = input("before_str after_str: ").split()

    if (len(s1) == len(s2)) != 1:
        print("str str の形式で入力してください")
        exit(0)
    dict_obj = {"before":s1, "after":s2}
    write_json(path, dict_obj)


if __name__ == '__main__':
    main()
