

from flask import Blueprint, request

from utils.http import get_common_json_response


product_bp = Blueprint('product', __name__)


@product_bp.get('/list')
def api_product_list():
    """
    get product list
    :return:
    """
    return get_common_json_response(
        data=[1, 2, 3, 4]
    )
