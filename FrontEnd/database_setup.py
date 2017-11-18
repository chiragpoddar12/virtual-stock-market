from sqlalchemy import Column, ForeignKey, Integer, String, DATETIME
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

Base = declarative_base()

# Connect to Database and create database session
engine = create_engine('sqlite:///vsmUser.db')
Base.metadata.bind = engine

DBSession = sessionmaker(bind=engine)
dbSession = DBSession()

class User(Base):
    __tablename__ = 'user'

    username = Column(String(250), primary_key=True)
    fullName = Column(String(250), nullable=False)
    email = Column(String(250), nullable=False)
    password = Column(String(250), nullable=False)



engine = create_engine('sqlite:///vsmUser.db')


Base.metadata.create_all(engine)