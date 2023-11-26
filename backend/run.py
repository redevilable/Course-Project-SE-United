
import flask
from flask_cors import CORS

from models import *
from settings import *


app = flask.Flask(__name__)


def init_db():
    """
    init database
    :return:
    """
    Base.metadata.create_all(bind=engine)


@app.teardown_appcontext
def shutdown_session(exception=None):
    """
    shutdown session
    :param exception:
    :return:
    """
    session.remove()


def register_blueprint():
    """
    register blueprint
    :return:
    """
    from api.product import product_bp

    app.register_blueprint(product_bp, url_prefix='/v1/product')


def main():
    """
    main function
    :return:
    """
    init_db()

    # cors enabled
    CORS(app)

    # register blueprint
    register_blueprint()

    app.run(
        host=HOST,
        port=PORT,
    )


if __name__ == '__main__':
    main()
