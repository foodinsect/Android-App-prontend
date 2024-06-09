# -*- coding: utf-8 -*-

!pip install openai

from openai import OpenAI

client = OpenAI(api_key="")

system = """아기의 개월수, 알레르기 정보, 집에 있는 재료, 기타 사항을 알려주면, 적합한 추천 이유식 레시피를 만들어줘.

입력 예시
개월 수: 8개월
알레르기 정보: 달걀 알레르기
집에 있는 재료: 당근, 닭가슴살, 소고기, 복숭아, 우유, 토마토
기타 사항: 칼슘 부족

출력 예시
1. 메뉴 이름: 닭가슴살과 당근 스튜
탄단지: 탄수화물 15g, 단백질 10g, 지방 2g
재료: 닭가슴살 30g, 당근 30g
간단한 레시피: 닭가슴살을 잘게 다진 후, 물과 함께 냄비에 넣고 끓입니다. 당근을 작게 썰어 추가하고 부드러워질 때까지 조리합니다.

2. 메뉴 이름: 소고기와 토마토 죽
탄단지: 탄수화물 20g, 단백질 12g, 지방 5g
재료: 소고기 30g, 토마토 20g, 쌀가루 20g
간단한 레시피: 소고기를 잘게 다진 후, 물에 쌀가루와 함께 넣고 죽이 될 때까지 끓입니다. 토마토를 잘게 썰어 죽에 넣고 잠시 더 끓입니다.

3. 메뉴 이름: 복숭아 우유 퓨레
탄단지: 탄수화물 18g, 단백질 5g, 지방 2g
재료: 복숭아 1개, 우유 100ml
간단한 레시피: 복숭아를 깨끗이 씻어 껍질을 벗기고 잘게 썬 뒤 믹서기에 넣습니다. 우유를 추가하고 부드러운 퓨레가 될 때까지 갈아줍니다.
"""

a1 = input("개월 수 : ")
a2 = input("알레르기 정보 : ")
a3 = input("집에 있는 재료 : ")
a4 = input("기타 사항 : ")

text = f"""개월 수 : {a1}
알레르기 정보 : {a2}
집에 있는 재료 : {a3}
기타 사항 : {a4}"""

completion = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "system", "content": system},
    {"role": "user", "content": text + "\n부가적인 설명 없이, 메뉴 이름과 탄단지, 재료, 간단한 레시피만 적어줘."}
  ]
)

print()
print(completion.choices[0].message.content)

from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
import numpy as np
import pandas as pd

# 이유식에 포함된 영양소들과 아기의 선호도 사이의 관계를 모델링
np.random.seed(1)
carbs = np.random.uniform(10, 20, 100)      # 탄수화물 (g)
protein = np.random.uniform(5, 15, 100)     # 단백질 (g)
fats = np.random.uniform(1, 5, 100)         # 지방 (g)
age_months = np.random.randint(6, 24, 100)  # 아기의 나이 (개월)

# 아기의 선호도는 영양소와 나이에 따라 달라짐
# 선호도는 0에서 10 사이의 값으로 표현 (선호도는 조사후 수정 필요)
preference = 5 + 0.5 * carbs - 0.3 * protein + 0.2 * fats + 0.1 * age_months + np.random.normal(0, 2, 100)

# DataFrame으로 변환
df_baby_food = pd.DataFrame(
    {
        'Carbohydrates': carbs,
        'Protein': protein,
        'Fats': fats,
        'Age_Months': age_months,
        'Preference': preference
    }
)

df_baby_food

# 데이터 분할: 80%는 학습용, 20%는 테스트용
X = df_baby_food.drop('Preference', axis=1)
y = df_baby_food['Preference']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1)

# 랜덤 포레스트 회귀 모델 학습
model_rf = RandomForestRegressor(random_state=1)
model_rf.fit(X_train, y_train)

# 예측 및 성능 평가
y_pred_rf = model_rf.predict(X_test)
mse_rf = mean_squared_error(y_test, y_pred_rf)

# 결과 출력
mse_rf

a = [15, 10, 3, 5]
result = model_rf.predict([a])
result

import tkinter as tk
from tkinter.scrolledtext import ScrolledText

def generate_recipe():
    text = f"""개월 수 : {month_entry.get()}
알레르기 정보 : {allergy_entry.get()}
집에 있는 재료 : {ingredients_entry.get()}
기타 사항 : {other_entry.get()}"""

    completion = client.chat.completions.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "system", "content": system},
    {"role": "user", "content": text + "\n부가적인 설명 없이, 메뉴 이름과 탄단지, 재료, 간단한 레시피만 적어줘."}
  ]
)

    output_text.delete(1.0, tk.END)
    output_text.insert(tk.INSERT, completion.choices[0].message.content)

root = tk.Tk()
root.title("Baby Food Recipe Generator")

tk.Label(root, text="개월 수:").grid(row=0, column=0)
month_entry = tk.Entry(root)
month_entry.grid(row=0, column=1)

tk.Label(root, text="알레르기 정보:").grid(row=1, column=0)
allergy_entry = tk.Entry(root)
allergy_entry.grid(row=1, column=1)

tk.Label(root, text="집에 있는 재료:").grid(row=2, column=0)
ingredients_entry = tk.Entry(root)
ingredients_entry.grid(row=2, column=1)

tk.Label(root, text="기타 사항:").grid(row=3, column=0)
other_entry = tk.Entry(root)
other_entry.grid(row=3, column=1)

generate_button = tk.Button(root, text="레시피 생성", command=generate_recipe)
generate_button.grid(row=4, column=0, columnspan=2)

tk.Label(root, text="추천 레시피:").grid(row=5, column=0)
output_text = ScrolledText(root, height=10, width=50)
output_text.grid(row=5, column=1, columnspan=2)

root.mainloop()