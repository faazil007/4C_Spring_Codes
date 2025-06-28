import pyodbc
from flask import Flask,jsonify,request
import pandas as pd

app = Flask(__name__)

conn = pyodbc.connect("DRIVER={SQL Server};SERVER=localhost;DATABASE=library")
cursor = conn.cursor()


@app.route('/books',methods=['GET'])
def allBooks():
    
    df = pd.read_sql_query("",conn)
    cursor.execute('select * from book')
    result = cursor.fetchall()
    books = []
    for row in result:
        record = {}
        record["id"] = row[0]
        record["title"] = row[1]
        record["author"] = row[2]
        books.append(record)
    return books



if __name__ == '__main__':
    app.run(debug=True)