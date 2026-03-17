import os

# 翻译字典
TRANSLATIONS = {
    "values": ["Million Calendar", "Selected Date: ", "Error"],
    "values-zh-rCN": ["百万日历", "选中日期：", "出错了"],
    "values-ja": ["ミリオンカレンダー", "選択された日付：", "エラー"],
    "values-ko": ["밀리언 캘린더", "선택된 날짜: ", "오류"],
    "values-de": ["Millionen Kalender", "Ausgewähltes Datum: ", "Fehler"]
}

KEYS = ["app_name", "tv_date_label", "msg_error"]
BASE_PATH = "app/src/main/res"

def generate():
    for folder, values in TRANSLATIONS.items():
        target_dir = os.path.join(BASE_PATH, folder)
        if not os.path.exists(target_dir):
            os.makedirs(target_dir)
        
        content = '<?xml version="1.0" encoding="utf-8"?>\n<resources>\n'
        for i in range(len(KEYS)):
            content += f'    <string name="{KEYS[i]}">{values[i]}</string>\n'
        content += '</resources>'
        
        with open(os.path.join(target_dir, "strings.xml"), "w", encoding="utf-8") as f:
            f.write(content)
    print("✅ 多语言资源 (Language Resources) 初始化成功！")

if __name__ == "__main__":
    generate()
