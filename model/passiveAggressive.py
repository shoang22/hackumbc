from joblib import load
from sklearn.feature_extraction.text import TfidfVectorizer

clf = load('passiveAggresive.joblib')
ex = ['this shit buggin b facebook.com']

tfidf_vectorizer=TfidfVectorizer(stop_words='english')
tfidf_train=tfidf_vectorizer.fit_transform(ex)

print(tfidf_train)

# clf.predict(ex)