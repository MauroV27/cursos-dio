from typing import List
from uuid import UUID

import pytest
from store.core.exceptions import NotFoundException
from store.schemas.product import ProductOut, ProductUpdateOut
from store.usecases.product import product_usecase

@pytest.mark.asyncio
async def test_usecases_create_should_return_success(product_in):
    result = await product_usecase.create(body=product_in)

    assert isinstance(result, ProductOut)
    assert result.name == "Iphone 14 Pro Max"


@pytest.mark.asyncio
async def test_usecases_get_should_return_success(product_inserted):
    data = await product_inserted
    result = await product_usecase.get(id=data.id)

    assert isinstance(result, ProductOut)
    assert result.name == "Iphone 14 Pro Max"


@pytest.mark.asyncio
async def test_usecases_get_should_not_found():
    with pytest.raises(NotFoundException) as err:
        await product_usecase.get(id=UUID("1e4f214e-85f7-461a-89d0-a751a32e3bb9"))

    assert (
        err.value.message
        == "Product not found with filter: 1e4f214e-85f7-461a-89d0-a751a32e3bb9"
    )


@pytest.mark.asyncio
@pytest.mark.usefixtures("products_inserted")
async def test_usecases_query_should_return_success():
    result = await product_usecase.query()

    assert isinstance(result, List)
    assert len(result) > 1


@pytest.mark.asyncio
async def test_usecases_update_should_return_success(product_up, product_inserted):
    product_up.price = "7.500"
    data = await product_inserted

    result = await product_usecase.update(id=data.id, body=product_up)

    assert isinstance(result, ProductUpdateOut)


@pytest.mark.asyncio
async def test_usecases_delete_should_return_success(product_inserted):

    data = await product_inserted

    result = await product_usecase.delete(id= data.id)

    assert result is True


@pytest.mark.asyncio
async def test_usecases_delete_should_not_found():
    with pytest.raises(NotFoundException) as err:
        await product_usecase.delete(id=UUID("1e4f214e-85f7-461a-89d0-a751a32e3bb9"))

    assert (
        err.value.message
        == "Product not found with filter: 1e4f214e-85f7-461a-89d0-a751a32e3bb9"
    )