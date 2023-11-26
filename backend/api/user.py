

from flask import Blueprint, request

from utils.http import get_common_json_response


user_bp = Blueprint('user', __name__)


@user_bp.get('/get_user_info')
def api_get_user_info():
    """
    get user info
    :return:
    """
    return get_common_json_response(
        data=None
    )


@user_bp.post('/login')
def api_login():
    """
    login
    :return:
    """
    return get_common_json_response(
        data=None
    )


@user_bp.post('/register')
def api_register():
    """
    register
    :return:
    """
    return get_common_json_response(
        data=None
    )


