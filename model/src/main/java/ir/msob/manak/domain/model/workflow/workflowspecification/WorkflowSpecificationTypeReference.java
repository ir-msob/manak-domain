package ir.msob.manak.domain.model.workflow.workflowspecification;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.manak.core.model.jima.channel.ChannelTypeReference;
import ir.msob.manak.core.model.jima.domain.DtoTypeReference;
import ir.msob.manak.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface WorkflowSpecificationTypeReference
        extends DtoTypeReference<WorkflowSpecificationDto, WorkflowSpecificationCriteria>
        , ChannelTypeReference<WorkflowSpecificationDto, WorkflowSpecificationCriteria> {

    @Override
    default TypeReference<PageResponse<WorkflowSpecificationDto>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<WorkflowSpecificationDto>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<WorkflowSpecificationCriteria> getCriteriaReferenceType() {
        return new TypeReference<WorkflowSpecificationCriteria>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<WorkflowSpecificationDto> getDtoReferenceType() {
        return new TypeReference<WorkflowSpecificationDto>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<String, WorkflowSpecificationCriteria>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<String, WorkflowSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<String, WorkflowSpecificationCriteria>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<String, WorkflowSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<String, WorkflowSpecificationDto>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<String, WorkflowSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<String, WorkflowSpecificationCriteria>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<String, WorkflowSpecificationCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<String, WorkflowSpecificationDto>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<String, WorkflowSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<String, WorkflowSpecificationDto>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<String, WorkflowSpecificationDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}