from flask import Flask,jsonify,request

app = Flask(__name__)
books = [
    {'id':1,'title':'Programming for AI', 'author':'Dr. Hassan'},
    {'id':2,'title':'Data Structures', 'author':'Dr. Munir'},
    {'id':3,'title':'Web programming', 'author':'Mr. Amir'},
]

@app.route("/")
def welcome():
    return "welcome to Flask!"

@app.route("/books",methods=['GET'])
def allBooks():
    return books

@app.route("/books",methods=['POST'])
def addBook():
    newBook = {'id':len(books)+1,
               'title':request.json['title'],
               'author':request.json['author']
               }
    books.append(newBook)
    return newBook

@app.route('/books/<int:id>',methods=['GET'])
def getBook(id):
    for book in books:
        if book['id'] == id:
            return book
    return {'ERROR':'No book found'}

@app.route('/books/<int:id>',methods=['PUT'])
def updateBook(id):
    for book in books:
        if book['id'] == id:
            book['title'] = request.json['title']
            book['author'] = request.json['author']
            return book
    return {'ERROR':'Book not found'}

@app.route('/books/<int:id>',methods=['DELETE'])
def deleteBook(id):
    for book in books:
        if book['id'] == id:
            books.remove(book)
            return {"Message":'book is removed'}
    return {"ERROR":"book not found"}

@app.route('/books/search',methods=['GET'])
def searchBook():
    print(len(request.args))
    if 'id' in request.args:
        id = int(request.args['id'])
        for book in books:
            if book['id'] == id:
                return jsonify(book)
        return {"ERROR":'No book found'}
    else:
        return {"ERROR":'Invalid call'}
#127.0.0.1 loopback IP
#localhost
#192.168.1.200
if __name__ == '__main__':
    app.run(debug=True)#, port=5000)




