from joblib import load
from sklearn.feature_extraction.text import TfidfVectorizer


vec = tfidf.transform(ex)
result = clf.predict(vec)
print(result)

if __name__ == '__main__':
    tfidf = load('tfidf.joblib')
    clf = load('passiveAggresive.joblib')

    with open('input.txt',encoding='utf8) as fl:
        txt = list(fl)

    vec = tfidf.transform(fl)
    result = clf.predict(vec)[0]

    f = open('output', 'w')
    f.write(result)