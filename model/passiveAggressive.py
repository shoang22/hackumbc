from joblib import load
from sklearn.feature_extraction.text import TfidfVectorizer

if __name__ == '__main__':
    tfidf = load('tfidf.joblib')
    clf = load('passiveAggresive.joblib')

    txt = list(open('..\input.txt',encoding='utf8'))

    vec = tfidf.transform(txt)
    result = str(clf.predict(vec)[0])

    f = open('..\output.txt', 'w')
    f.write(result)
