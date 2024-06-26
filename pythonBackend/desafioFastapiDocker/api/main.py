from fastapi import FastAPI
from api.routes import api_router

app = FastAPI(title='WorkoutApi')
app.include_router(api_router)