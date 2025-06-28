from  sqlalchemy import Column, Integer, String, create_engine,ForeignKey
from sqlalchemy.orm import declarative_base

db_url = "sqlite:///database.db"

engine = create_engine(db_url)

Base = declarative_base()

class User(Base):
    __tablename__ = "user"

    id = Column(Integer,primary_key=True)
    name = Column(String)#,ForeignKey('table.id'))
    age = Column(Integer)
    classId = Column(Integer, ForeignKey('class.id'))
    deptId = Column(Integer, ForeignKey('department.id'))

class Class(Base):
    __tablename__ = "class"

    id = Column(Integer,primary_key=True)
    title = Column(String)
    strength = Column(Integer)

class Department(Base):
    __tablename__ = "department"

    id = Column(Integer,primary_key=True)
    name = Column(String(50))


Base.metadata.create_all(engine)
