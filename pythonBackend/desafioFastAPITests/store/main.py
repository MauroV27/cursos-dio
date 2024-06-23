from fastapi import FastAPI

from store.core.config import settings
from store.routes import api_router

class App(FastAPI):
    def __init__(self, *args, **kwargs) -> None:
        super().__init__(
            *args,
            **kwargs,
            version="0.0.1",
            title=settings.PROJECT_NAME,
            root_path=settings.ROOT_PATH
        )

app = App()

@app.get("openapi.json")
def custom_swagger_ui_html():
    return app.openapi()

@app.get("/ping")
async def ping():
    return {"message" : "Pong"}

app.include_router(api_router)
