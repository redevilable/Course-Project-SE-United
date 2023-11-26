
from sqlalchemy import create_engine
from sqlalchemy import BigInteger, Column, DateTime, String, text
from sqlalchemy.dialects.mysql import BIGINT, INTEGER, TINYINT
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import scoped_session, sessionmaker

from settings import MYSQL_URL


engine = create_engine(MYSQL_URL)
session = scoped_session(
    sessionmaker(
        autocommit=False,
        autoflush=True,
        bind=engine
    )
)

Base = declarative_base()
metadata = Base.metadata
Base.query = session.query_property()


class TProject(Base):
    __tablename__ = 't_project'

    id = Column(BIGINT, primary_key=True, comment='project id')
    name = Column(String(256), comment='name')
    desc = Column(String(512), comment='desc')
    creator = Column(String(64), comment='creator')
    status = Column(TINYINT, server_default=text("'1'"), comment='0=disabled 1=enabled')
    create_time = Column(INTEGER, comment='create time')
    update_time = Column(INTEGER, comment='update_time')


class TSprint(Base):
    __tablename__ = 't_sprint'

    id = Column(BIGINT, primary_key=True, comment='iteration id')
    project_id = Column(BIGINT, index=True, comment='project id')
    name = Column(String(256), comment='name')
    desc = Column(String(512), comment='desc')
    status = Column(TINYINT, server_default=text("'1'"), comment='0=disabled 1=enabled')
    start_time = Column(DateTime, comment='start time')
    end_time = Column(DateTime, comment='end time')
    create_time = Column(INTEGER, comment='create_time')
    update_time = Column(INTEGER, comment='update_time')


class TUserstory(Base):
    __tablename__ = 't_userstory'

    id = Column(BIGINT, primary_key=True, comment='id')
    sprint_id = Column(BigInteger, comment='sprint id')
    name = Column(String(256), comment='name')
    desc = Column(String(512), comment='desc')
    priority = Column(TINYINT, server_default=text("'0'"), comment='priority')
    start_time = Column(INTEGER, comment='start_time')
    end_time = Column(INTEGER, comment='end_time')
    creator = Column(BigInteger, comment='creator user id')
    executor = Column(BIGINT, comment='executor user id')
    status = Column(TINYINT, server_default=text("'1'"), comment='0=disabled 1=enabled')
    create_time = Column(INTEGER, comment='create_time')
    update_time = Column(INTEGER, comment='update_time')
